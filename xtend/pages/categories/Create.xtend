package pages.categories

import pages.Layout
import webtend.mvc.Route
import models.Category

@Route("/categories/create")
class Create extends Layout {

	override handle() {
		val alias = request.getParameter("alias")
		val name = request.getParameter("name")
		val category = new Category
		category.alias = alias
		category.name = name
		category.save
		'''created'''.asHtml
	}

}
