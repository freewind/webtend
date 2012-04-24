package webtend.mvc.results;

import webtend.Helper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 向response中输出html字符串的操作类。
 */
public class HtmlResult extends RenderResult {
	/**
	 * 要输出的html内容。
	 */
	private String html;

	/**
	 * 构造函数。
	 *
	 * @param html
	 *            要输出的html内容，不可为null
	 * @throws IllegalArgumentException
	 *             如果参数不合要求
	 */
	public HtmlResult(String html) {
		Helper.notNull(html, "html");
		this.html = html;
	}

	/**
	 * {@inheritDoc}
	 *
	 * 本方法直接向response中输出HTML字符串，response的contentType将设为 <code>text/html</code>.
	 *
	 * @return null
	 */
	@Override
	public void handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		super.handle(request, response);
		response.setContentType(MIMETYPE_HTML);
		response.getWriter().write(html);
	}

}
