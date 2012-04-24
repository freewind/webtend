package webtend.mvc.results;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RenderResult {

	/**
	 * HTML对应的MIME类型。
	 */
	public static final String MIMETYPE_HTML = "text/html";

	/**
	 * TEXT对应的MIME类型。
	 */
	public static final String MIMETYPE_TEXT = "text/plain";

	public static final String MIMETYPE_JSON = "application/json";

	/**
	 * 二进制流对应的MIME类型。
	 */
	public static final String MIMETYPE_BINARY = "application/octet-stream";

	public static final String MIMETYPE_GIF = "image/gif";

	public static final String MIMETYPE_PNG = "image/png";

	public static final String MIMETYPE_JPG = "image/jpeg";

	public static final String MIMETYPE_BMP = "application/x-MS-bmp";

	/**
	 * Response返回给客户端的状态码，默认为200，表示成功。
	 */
	protected int statusCode = 200;

	/**
	 * @param statusCode
	 *            设置状态码
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * 处理请求，向客户端发送数据或返回ActionForward由struts来处理。如果是jsp，则返回一个ActionForward； 其它情况直接向response中输出，返回null。
	 *
	 * @param request
	 *            request
	 * @param response
	 *            response
	 * @return 如果是jsp，则返回一个ActionForward； 其它情况直接向response中输出，返回null。
	 * @throws Exception
	 *             操作中出现任何异常
	 */
	public void handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setStatus(statusCode);
		response.setCharacterEncoding("UTF-8");
	}
}
