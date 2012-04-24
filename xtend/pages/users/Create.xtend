package pages.users

import webtend.mvc.HttpMethod
import webtend.mvc.Route
import pages.Layout
import models.User
@Route(value="/users/create", method=HttpMethod::post)
class Create extends Layout {

	override handle() {
		val name = request.getParameter("name")
		val email = request.getParameter("email")
		val user = new User
		user.name = name
		user.email = email
		user.save
		"saved".asHtml
	}

}
