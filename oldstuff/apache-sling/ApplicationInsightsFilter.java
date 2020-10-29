package bugbash;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.sling.servlets.annotations.SlingServletFilter;

import com.microsoft.applicationinsights.web.internal.WebRequestTrackingFilter;

@SlingServletFilter
public class ApplicationInsightsFilter implements Filter {

    private WebRequestTrackingFilter webRequestTrackingFilter;

    @Override
    public void destroy() {
        webRequestTrackingFilter.destroy();

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {
        webRequestTrackingFilter.doFilter(servletRequest, servletResponse, filterChain);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        webRequestTrackingFilter = new WebRequestTrackingFilter();
        webRequestTrackingFilter.init(filterConfig);
    }
}
