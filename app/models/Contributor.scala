package models

import java.util.Date
import play.api.libs.json._
import java.time.LocalDateTime

case class Contributor(
    name: String,
    since: LocalDateTime,
    totalAmountDonated: Int,
    `type`: String,
    description: Option[String],
    collectiveSlug: Option[String],
    image: String
)

object Contributor {
    implicit val format: OFormat[Contributor] = Json.format[Contributor]
}
