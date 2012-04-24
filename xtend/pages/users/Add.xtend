package pages.users

import pages.Layout
import webtend.mvc.Route

@Route("/users/add")
class Add extends Layout {

	override handle() {
		main("新建用户") [|'''
		<form action="«context»/users/create" method="post"">
			<input type="text" name="name" />
			<input type="text" name="email" />
			<input type="submit" value="提交" />
		</form>
		'''].asHtml
	}

	def url(=>String action) {
		action.getClass.name
	}

}
