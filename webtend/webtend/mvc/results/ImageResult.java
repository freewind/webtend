package webtend.mvc.results;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class ImageResult extends RenderResult {

	private File file;

	public ImageResult(File file) {
		this.file = file;
	}

	@Override
	public void handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		super.handle(request, response);

		String contentType = null;
		String filename = file.getName().toLowerCase();
		if (filename.endsWith(".gif")) {
			contentType = MIMETYPE_GIF;
		} else if (filename.endsWith(".bmp")) {
			contentType = MIMETYPE_BMP;
		} else if (filename.endsWith(".png")) {
			contentType = MIMETYPE_PNG;
		} else if (filename.endsWith(".jpg")) {
			contentType = MIMETYPE_JPG;
		}

		if (contentType == null) {
			response.setContentType(contentType);
		}

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
