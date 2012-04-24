package webtend.mvc.results;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectResult extends RenderResult {

	private String url;

	public RedirectResult(String url) {
		this.url = url;
	}

	@Override
	public void handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		super.handle(request, response);
		response.sendRedirect(url);
	}
}
