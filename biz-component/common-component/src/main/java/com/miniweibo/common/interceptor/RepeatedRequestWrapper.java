package com.miniweibo.common.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * making httpServletRequest can read repeated
 * @author xiaoshun.cxs
 * @date 2020/8/25
 **/
@Component
public class RepeatedRequestWrapper extends HttpServletRequestWrapper {

    private String body;

    public RepeatedRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        InputStream is = request.getInputStream();
        this.body = StreamUtils.copyToString(request.getInputStream(), Charset.defaultCharset());
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(body.getBytes());
        return new ServletInputStream() {
            @Override
            public boolean isFinished() { return false; }

            @Override
            public boolean isReady() { return false; }

            @Override
            public void setReadListener(ReadListener readListener) { }

            @Override
            public int read() throws IOException {
                return bais.read();
            }
        };
    }

    public String getBody() {
        return body;
    }
}
