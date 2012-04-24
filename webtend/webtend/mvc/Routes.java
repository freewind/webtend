package webtend.mvc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;

import org.reflections.Reflections;

public class Routes {

	private Map<Route, Class<? extends Page>> map = new HashMap();

	public Routes(String pagesPkg) {
		Reflections reflections = new Reflections(pagesPkg);
		Set<Class<? extends Page>> pageClasses = reflections.getSubTypesOf(Page.class);
		for (Class<? extends Page> pageCls : pageClasses) {
			Route route = pageCls.getAnnotation(Route.class);
			System.out.println("### found model: " + pageCls.getName());
			if (route != null) {
				map.put(route, pageCls);
			}
		}
	}

	public Page findTarget(HttpMethod method, String uri) throws ServletException {
		for (Route route : map.keySet()) {
			if (route.method() == HttpMethod.any || route.method() == method) {
				Map<String, String> result = UrlMatcher.match(route.value(), uri);
				if (result != null) {
					Class<? extends Page> pageCls = map.get(route);
					try {
						Page page = pageCls.newInstance();
						page.setRouteParams(result);
						return page;
					} catch (InstantiationException e) {
						throw new ServletException(pageCls.getSimpleName() + " can't be created", e);
					} catch (IllegalAccessException e) {
						throw new ServletException(e);
					}
				}
			}
		}
		return null;
	}

}
