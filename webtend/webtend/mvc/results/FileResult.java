package webtend.mvc.results;

import static org.apache.commons.lang.StringUtils.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.io.IOUtils;

import webtend.Helper;

/**
 * 向response中输出一个文件内容供下载的操作类，response的contentType将设为 <code>application/octet-stream</code>.
 */
public class FileResult extends RenderResult {

	/**
	 * 要输出的文件。
	 */
	private File file;

	/**
	 * 文件在下载提示框上的显示名称。
	 */
	private String displayName;

	/**
	 * 构造函数。
	 *
	 * @param file
	 *            要输出的二进制流，不可为null
	 * @param displayName
	 *            文件在下载提示框上的显示名称。如果为null或空，则以文件实际名称代替。
	 * @throws IllegalArgumentException
	 *             如果参数不合要求
	 */
	public FileResult(File file, String displayName) {
		Helper.notNull(file, "input");
		this.file = file;
		this.displayName = displayName;
		if (isBlank(displayName)) {
			this.displayName = displayName;
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * 本方法直接向response中输出二进制流，response的contentType将设为 <code>application/octet-stream</code>.
	 *
	 * @return null
	 */
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		super.handle(request, response);
		String downloadName = new String(displayName.getBytes("GBK"),
			"iso-8859-1");
		response.setContentType(MIMETYPE_BINARY);
		response.setHeader("Content-Length", "" + file.length());
		response.setHeader("Content-Disposition", String.format(
			"attachment; name=\"%s\"; filename=\"%s\"", downloadName,
			downloadName));
		OutputStream output = response.getOutputStream();
		InputStream input = null;
		try {
			input = new FileInputStream(file);
			IOUtils.copy(input, output);
		} finally {
			IOUtils.closeQuietly(input);
		}
	}
}
