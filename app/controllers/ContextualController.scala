package controllers

import com.typesafe.config.Config
import io.sdkman.repos.{CandidatesRepo => ICandidatesRepo}
import javax.inject._
import play.api.mvc._
import support.MongoConnection
import net.ceedubs.ficus.Ficus._
import net.ceedubs.ficus.readers.ArbitraryTypeReader._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

@Singleton
class ContextualController @Inject()(cc: ControllerComponents,
                                     candidatesRepo: CandidatesRepo,
                                     conf: Config) extends AbstractController(cc) {

  val index = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  val install = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.install())
  }

  val usage = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.usage())
  }

  val vendors = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.vendors())
  }

  def jdks = Action.async { _ =>
    Future.successful(Ok(views.html.jdks(conf.as[Seq[Jdk]]("jdks.vendors"))))
  }

  def sdks = Action.async { _ =>
    candidatesRepo.findAllCandidates().map { candidates =>
      val sanitisedCandidates = candidates.filter(c => !Seq("java", "test").contains(c.candidate))
      Ok(views.html.sdks(sanitisedCandidates))
    }
  }
}

case class Jdk(id: String, vendor: String, distribution: String, url: String, description: String)

@Singleton
class CandidatesRepo extends ICandidatesRepo with MongoConnection
