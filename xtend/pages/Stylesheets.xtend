package pages

import java.io.File
import webtend.Webtend
import webtend.mvc.Page
import webtend.mvc.Route

@Route("/stylesheets/<file:.*>")
class Stylesheets extends Page {

	override handle() {
		new File(Webtend::rootPath, "stylesheets/" + routeParams.get("file")).asFile()
	}

}
