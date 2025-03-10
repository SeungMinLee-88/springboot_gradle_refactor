package studio.thinkground.client;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.util.internal.StringUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;

@Slf4j
@AllArgsConstructor
public class LoggingHandler extends ChannelDuplexHandler {
  private static final String LOG_TEMPLATE_RECEIVE_FULL = "[WEBCLIENT] RECEIVE METHOD : , URI : , HEADERS : , BODY : ";

  private static final String LOG_TEMPLATE_SNT_BODY = "[WEBCLIENT] SENT BODY : ";

  private static final String PASSWORD_REGEX = "password=(.*?)&";
  private static final String PASSWORD_REPLACEMENT = "password=******&";
  private String msName;

  @Override
  public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
    if(msg instanceof FullHttpRequest){

    }else if(msg instanceof HttpContent){

    }
    super.write(ctx, msg, promise);
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    if(msg instanceof HttpResponse){
      logFullHttpRequest((FullHttpRequest) msg);
    }else if(!(msg instanceof LastHttpContent && msg instanceof HttpContent)){
      logHttpRequest((FullHttpRequest) msg);

    }
    super.channelRead(ctx, msg);
  }

  private void logHttpRequest(final FullHttpRequest request){
    log.info("{}{}{}{}", msName, request.method(), request.uri(), request.headers());
  }

  private void logFullHttpRequest(final FullHttpRequest request){
    log.info(LOG_TEMPLATE_RECEIVE_FULL, msName, request.uri(), request.method(), markSensitiveFields(request.content().toString(Charset.defaultCharset())),
            request.headers());
  }

  private String markSensitiveFields(String response){
    if(StringUtil.isNullOrEmpty(response)){
      return null;
    }
    return response.replaceAll(PASSWORD_REGEX, PASSWORD_REPLACEMENT);
  }
}
