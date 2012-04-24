package webtend;

import static org.apache.commons.lang.StringUtils.*;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import webtend.mvc.AllToOneServlet;
import webtend.mvc.HttpMethod;
import webtend.mvc.Page;
import webtend.mvc.Routes;
import webtend.mvc.results.RenderResult;

public class Webtend extends AllToOneServlet {

	private Routes routes;

	private static final boolean IS_DEBUGING = isDebuging();

	private String pagesPkg = "pages";

	private static String rootPath;

	public static Logger logger = LoggerFactory.getLogger(Webtend.class);

	@Override
	public void init(ServletConfig config) throws ServletException {
		rootPath = config.getServletContext().getRealPath("/");

		String pkg = config.getInitParameter("pagesPkg");
		if (isNotBlank(pkg)) {
			pagesPkg = pkg;
		}

		initRoutes();
	}

	private void initRoutes() {
		System.out.println("### init routes ...");
		this.routes = new Routes(pagesPkg);
	}

	protected void handle(HttpMethod method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (IS_DEBUGING) {
			initRoutes();
		}

		Page page = routes.findTarget(method, getUri(req));
		if (page == null) {
			resp.setStatus(404);
		} else {
			page.setRequest(req);
			page.setResponse(resp);
			RenderResult result = page.handle();
			try {
				result.handle(req, resp);
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
	}

	private String getUri(HttpServletRequest req) {
		return removeStart(req.getRequestURI(), req.getContextPath());
	}

	private static boolean isDebuging() {
		return java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;
	}

	public static String getRootPath() {
		return rootPath;
	}

}
