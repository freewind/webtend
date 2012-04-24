package pages

import models.Article
import webtend.mvc.Route

@Route("/index")
class Index extends Layout {

	override handle() {
		val articles = Article::find.findList
		main("知博") [|'''




<div class="">
	«FOR article: articles»
		<div class="article">
			<div class="title">«article.title»</div>
			<div class="content">«article.paragraphs»</div>
		</div>
	«ENDFOR»
</div>




		'''].asHtml
	}

}
