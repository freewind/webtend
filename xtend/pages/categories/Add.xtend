package pages.categories

import pages.Layout
import webtend.mvc.Route
@Route("/categories/add")
class Add extends Layout {

	override handle() {
'''
<form action="«context»/categories/create" method="post">
	<input type="text" name="alias" />
	<input type="text" name="name"  />
	<input type="submit" value="创建" />
</form>
'''.asHtml
	}

}
