package studio.thinkground.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class HttpInterceptor implements HandlerInterceptor {
  private final Logger LOGGER = LoggerFactory.getLogger(HttpInterceptor.class);

  @Override
  public boolean preHandle(
      HttpServletRequest request, HttpServletResponse response, Object handler) {
    LOGGER.info("preHandle called");
    LOGGER.info("preHandle request : " + request);
    LOGGER.info("preHandle path info :" + request.getPathInfo());
    LOGGER.info("preHandle header names :" + request.getHeaderNames());
    LOGGER.info("preHandle url :" + request.getRequestURL());
    LOGGER.info("preHandle uri :" + request.getRequestURI());
    LOGGER.info("preHandle session :" + request.getRequestedSessionId());

    return true;
  }

  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      @Nullable ModelAndView modelAndView)
      throws Exception {

    LOGGER.info("postHandle called");
    LOGGER.info("postHandle request : " + request);
    LOGGER.info("postHandle path info :" + request.getPathInfo());
    LOGGER.info("postHandle header names :" + request.getHeaderNames());
  }

  public void afterCompletion(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      @Nullable Exception ex)
      throws Exception {

    LOGGER.info("afterCompletion called");
  }
}
