package wrappers

import javax.inject.Inject
import com.typesafe.config.Config
import play.api.http.Status._
import play.api.libs.ws.WSClient
import play.api.libs.json.{Json, JsValue}

import scala.concurrent.{ExecutionContext, Future}

class OpenCollectiveWebApi @Inject() (
  ws: WSClient,
  conf: Config,
  implicit val ec: ExecutionContext
) {
  val url = conf.getString("openCollective.url")

  val query = Json.obj(
      "query" -> """
          query Collective {
              collective(slug: "sdkman") {
                  contributors(limit: 200, offset: 0) {
                      totalCount
                      nodes {
                          name
                          since
                          totalAmountDonated
                          type
                          description
                          image
                      }
                  }
              }
          }
      """
  )

  def getContributors(): Future[JsValue] = {
    ws
      .url(url)
      .addHttpHeaders("Accept" -> "application/json")
      .post(query)
      .map { response =>
        if (response.status == OK) {
          (response.json \ "data" \ "collective" \ "contributors" \ "nodes").as[JsValue]
        } else {
          throw ApiError(response.status, Some(response.statusText))
        }
      }
  }
}
