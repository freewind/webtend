package pages

import java.io.File
import webtend.Webtend
import webtend.mvc.Page
import webtend.mvc.Route

@Route("/javascripts/<file:.*>")
class Javascripts extends Page {

	override handle() {
		new File(Webtend::rootPath, "javascripts/" + routeParams.get("file")).asFile()
	}

}
