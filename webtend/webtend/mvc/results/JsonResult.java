package webtend.mvc.results;

import webtend.Helper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 向response中输出json字符串的操作类。
 */
public class JsonResult extends RenderResult {

	/**
	 * 要输出的json内容。
	 */
	private String json;

	/**
	 * 构造函数。
	 *
	 * @param json
	 *            要输出的json内容，不可为null
	 * @throws IllegalArgumentException
	 *             如果参数不合要求
	 */
	public JsonResult(String json) {
		Helper.notNull(json, "json");
		this.json = json;
	}

	/**
	 * {@inheritDoc}
	 *
	 * 本方法直接向response中输出json字符串，response的contentType将设为 <code>text/json</code>.
	 *
	 * @return null
	 */
	@Override
	public void handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		super.handle(request, response);
		response.setContentType(MIMETYPE_JSON);
		response.getWriter().write(json);
	}

}
