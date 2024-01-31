package controllers

import com.typesafe.config.Config
import io.sdkman.repos.{CandidatesRepo => ICandidatesRepo}
import net.ceedubs.ficus.Ficus._
import net.ceedubs.ficus.readers.ArbitraryTypeReader._
import play.api.mvc._
import support.MongoConnection

import javax.inject._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

import services.OpenCollectiveService
import models.Contributor

@Singleton
class ContextualController @Inject() (
    cc: ControllerComponents,
    applicationRepo: ApplicationRepo,
    candidatesRepo: CandidatesRepo,
    conf: Config,
    openCollectiveService: OpenCollectiveService
) extends AbstractController(cc) {

  val index = Action.async { implicit request: Request[AnyContent] =>
    openCollectiveService.getContributors().map { result => 
      val data = result.groupBy(_.`type`)
      val organizationContributors = data.getOrElse("ORGANIZATION", Seq[Contributor]())
      val individualContributors = data.getOrElse("USER", Seq[Contributor]())

      Ok(views.html.index(organizationContributors, individualContributors))
    }
  }

  val install = Action.async { implicit request: Request[AnyContent] =>
    applicationRepo.findApplication().map { app =>
      val scriptCliVersion = app.map(_.stableCliVersion).getOrElse("6.0.0")
      val nativeCliVersion = app.map(_.stableNativeCliVersion).getOrElse("1.0.0")
      Ok(views.html.install(scriptCliVersion, nativeCliVersion))
    }
  }

  val usage = Action.async { implicit request: Request[AnyContent] =>
    candidatesRepo.findAllCandidates().map { candidates =>
      val candidateVersions = candidates
        .map(c => Tuple2(c.candidate, c.default.getOrElse("x.y.z")))
        .toMap
      Ok(views.html.usage(candidateVersions))
    }
  }

  val vendors = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.vendors())
  }

  def jdks = Action.async { implicit request: Request[AnyContent] =>
    Future.successful(
      Ok(
        views.html.jdks(
          conf.as[Seq[Jdk]]("jdks.vendors").sortBy(_.distribution)
        )
      )
    )
  }

  def sdks = Action.async { implicit request: Request[AnyContent] =>
    candidatesRepo.findAllCandidates().map { candidates =>
      val sanitisedCandidates =
        candidates.filter(c => !Seq("java", "test").contains(c.candidate))
      Ok(views.html.sdks(sanitisedCandidates))
    }
  }

  def contributors = Action.async { implicit request: Request[AnyContent] =>
    openCollectiveService.getContributors().map { result => 
      val data = result.groupBy(_.`type`)
      val organizationContributors = data.getOrElse("ORGANIZATION", Seq[Contributor]())
      val individualContributors = data.getOrElse("USER", Seq[Contributor]())

      Ok(views.html.contributors(organizationContributors, individualContributors))
    }
  }
}

case class Jdk(
    id: String,
    vendor: String,
    distribution: String,
    url: String,
    description: String
)

@Singleton
class CandidatesRepo extends ICandidatesRepo with MongoConnection
