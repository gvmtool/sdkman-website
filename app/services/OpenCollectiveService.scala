package services

import javax.inject.Inject
import play.api.cache.AsyncCacheApi
import play.api.libs.json.JsValue

import scala.concurrent.duration.{Duration, HOURS}
import scala.concurrent.{ExecutionContext, Future}

import wrappers.OpenCollectiveWebApi
import models.Contributor

class OpenCollectiveService @Inject() (
  openCollectiveWebApi: OpenCollectiveWebApi,
  cache: AsyncCacheApi,
  implicit val ec: ExecutionContext
) {
  val cacheExpiry: Duration = Duration(1, HOURS)

  def getContributors(): Future[Seq[Contributor]] = {
    cache.getOrElseUpdate[JsValue]("open-collective-cache", cacheExpiry) {
      openCollectiveWebApi.getContributors()
    }
    .map(_.as[Seq[Contributor]].filter(_.totalAmountDonated > 0))
  }
}
