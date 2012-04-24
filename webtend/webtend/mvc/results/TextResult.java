package webtend.mvc.results;

import webtend.Helper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 向response中输出text字符串的操作类，response的contentType将设为<code>text/plain</code>.
 */
public class TextResult extends RenderResult {
	/**
	 * 要输出的text内容。
	 */
	private String text;

	/**
	 * 构造函数。
	 *
	 * @param text
	 *            要输出的text内容，不可为null
	 * @throws IllegalArgumentException
	 *             如果参数不合要求
	 */
	public TextResult(String text) {
		Helper.notNull(text, "text");
		this.text = text;
	}

	/**
	 * {@inheritDoc}
	 *
	 * 本方法直接向response中输出TEXT字符串，response的contentType将设为 <code>text/plain</code>.
	 *
	 * @return null
	 */
	@Override
	public void handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		super.handle(request, response);
		response.setContentType(MIMETYPE_TEXT);
		response.getWriter().write(text);
	}

}
