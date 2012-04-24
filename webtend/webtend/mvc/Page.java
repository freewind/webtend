package webtend.mvc;

import java.io.File;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtend.mvc.results.FileResult;
import webtend.mvc.results.HtmlResult;
import webtend.mvc.results.JsonResult;
import webtend.mvc.results.RenderResult;

public abstract class Page {

	protected Map<String, String> routeParams;

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	public abstract RenderResult handle();

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setRouteParams(Map<String, String> routeParams) {
		this.routeParams = routeParams;
	}

	// convert results
	protected RenderResult asHtml(CharSequence html) {
		return new HtmlResult(html.toString());
	}

	protected RenderResult asJson(CharSequence json) {
		return new JsonResult(json.toString());
	}

	protected RenderResult asFile(File file) {
		return new FileResult(file, file.getName());
	}

	protected RenderResult asFile(File file, String displayName) {
		return new FileResult(file, displayName);
	}

}
