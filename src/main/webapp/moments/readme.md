以下部分加在  server.xml <Value> 下
<Context path="/wechat/img" docBase="e:\wechat\img" reloadable="true" crossContext="true" />



以下部分加在  web.xml
<filter>
 <filter-name>CorsFilter</filter-name>
 <filter-class>org.apache.catalina.filters.CorsFilter</filter-class>
 <init-param>
   <param-name>cors.allowed.methods</param-name>
   <param-value>GET,POST,HEAD,OPTIONS,PUT</param-value>
 </init-param>
 <init-param>
   <param-name>cors.allowed.headers</param-name>
   <!--注意，若你的应用中不只有这些文件头，则需要将你应用中需要传的文件头也加上；
   例如：我的应用中需要在header中传token，所以这里的值就应该是下面的配置，在原有基础上将token加上，否则，应用就不会被允许调用
   <param-value>token,Access-Control-Allow-Origin,Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers</param-value>
   -->
   <param-value>Access-Control-Allow-Origin,Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers</param-value>
 </init-param>
 <async-supported>true</async-supported>
</filter>
<filter-mapping>
 <filter-name>CorsFilter</filter-name>
 <url-pattern>/*</url-pattern>
</filter-mapping>
