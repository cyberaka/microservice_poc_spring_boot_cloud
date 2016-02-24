<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1456251919035" ID="ID_359390739" MODIFIED="1456252829905" TEXT="Assignment Analysis">
<node CREATED="1456252814330" ID="ID_6985399" MODIFIED="1456252817648" POSITION="right" TEXT="Required Deliverables">
<node CREATED="1456251953863" ID="ID_496980463" MODIFIED="1456251958356" TEXT="Logical Diagram">
<node CREATED="1456252021716" ID="ID_949626508" MODIFIED="1456252025140" TEXT="Functional Requirements">
<node CREATED="1456251976993" ID="ID_591333247" MODIFIED="1456251979092" TEXT="The Service"/>
<node CREATED="1456251979323" ID="ID_1160232875" MODIFIED="1456251981283" TEXT="The Database"/>
<node CREATED="1456251981522" ID="ID_711209898" MODIFIED="1456251986027" TEXT="Clients of the service"/>
</node>
<node CREATED="1456252011096" ID="ID_905629924" MODIFIED="1456252020804" TEXT="Non Functional Requirements">
<node CREATED="1456252032031" ID="ID_1222813596" MODIFIED="1456252037074" TEXT="Service Discovery"/>
<node CREATED="1456252037395" ID="ID_404686607" MODIFIED="1456252039549" TEXT="Load Balancing"/>
<node CREATED="1456252039967" ID="ID_1230356054" MODIFIED="1456252041682" TEXT="Monitoring"/>
</node>
</node>
<node CREATED="1456252094877" ID="ID_1217570232" MODIFIED="1456252100770" TEXT="To Code">
<node CREATED="1456252101001" ID="ID_207386510" MODIFIED="1456252108314" TEXT="Product Catalogue Service">
<node CREATED="1456252109520" ID="ID_894978665" MODIFIED="1456252114353" TEXT="Create">
<node CREATED="1456252159214" ID="ID_911153196" MODIFIED="1456252161401" TEXT="Add a product"/>
</node>
<node CREATED="1456252114912" ID="ID_1855495402" MODIFIED="1456252115881" TEXT="Read">
<node CREATED="1456252167149" ID="ID_714423570" MODIFIED="1456252172288" TEXT="Read details of a single product"/>
<node CREATED="1456252172549" ID="ID_218466231" MODIFIED="1456252173560" TEXT="List based on simple search criteria "/>
</node>
<node CREATED="1456252118215" ID="ID_1966121483" MODIFIED="1456252119281" TEXT="Delete">
<node CREATED="1456252140773" ID="ID_1319943051" MODIFIED="1456252146139" TEXT="Remove a product from catalogue"/>
</node>
</node>
<node CREATED="1456252212432" ID="ID_721797404" MODIFIED="1456252215129" TEXT="Pricing Service">
<node CREATED="1456252215414" ID="ID_378110575" MODIFIED="1456252234985" TEXT="Read">
<node CREATED="1456252242713" ID="ID_1306027697" MODIFIED="1456252254484" TEXT="Return the price for a given product"/>
</node>
<node CREATED="1456252258704" ID="ID_406696021" MODIFIED="1456252269007" TEXT="Need to interact with product catalogue service">
<node CREATED="1456252269339" ID="ID_741948638" MODIFIED="1456252276899" TEXT="To retrieve any required details for given product"/>
</node>
</node>
<node CREATED="1456252329134" ID="ID_1932691889" MODIFIED="1456252332185" TEXT="JSON Format">
<node CREATED="1456252332416" ID="ID_222916127" MODIFIED="1456252340177" TEXT="Input / Request"/>
<node CREATED="1456252334304" ID="ID_243639125" MODIFIED="1456252344520" TEXT="Output / Response"/>
</node>
</node>
<node CREATED="1456252182578" ID="ID_1924531184" MODIFIED="1456252812172" TEXT="Deployment Requirement">
<node CREATED="1456252186211" ID="ID_1048604038" MODIFIED="1456252195553" TEXT="The service should be independently hosted"/>
<node CREATED="1456252195809" ID="ID_299897802" MODIFIED="1456252201729" TEXT="Accessible over http port."/>
<node CREATED="1456252202015" ID="ID_1964502753" MODIFIED="1456252209833" TEXT="Use an in-memory database of your choice"/>
</node>
</node>
<node CREATED="1456252301203" ID="ID_894465476" MODIFIED="1456252306049" POSITION="right" TEXT="Assumptions">
<node CREATED="1456252387832" ID="ID_910654732" MODIFIED="1456252436850" TEXT="It is acceptable to use Spring Boot and Spring Cloud for this implementation"/>
<node CREATED="1456252437247" ID="ID_971224529" MODIFIED="1456252462602" TEXT="Distributed Version Control System like Git is acceptable and there is no need of subversion as of now."/>
<node CREATED="1456252484794" ID="ID_1539274969" MODIFIED="1456252488770" TEXT="No UI is needed as of now">
<node CREATED="1456252489792" ID="ID_146761325" MODIFIED="1456252503882" TEXT="Demonstration will be done using">
<node CREATED="1456252504163" ID="ID_133509442" MODIFIED="1456252506163" TEXT="Test Cases"/>
<node CREATED="1456252506603" ID="ID_736332376" MODIFIED="1456252532722" TEXT="Chrome REST tools like POST MAN, Advance Rest Client"/>
</node>
</node>
<node CREATED="1456252548566" ID="ID_1843739770" MODIFIED="1456252562526" TEXT="It is acceptable to use Maven as the build system">
<node CREATED="1456252562750" ID="ID_1405525520" MODIFIED="1456252573375" TEXT="Eclipse IDE settings will be generated if needed"/>
<node CREATED="1456252573670" ID="ID_1185113294" MODIFIED="1456252586352" TEXT="Netbeans IDE supports Maven projects without adding any new metadata"/>
</node>
<node CREATED="1456252594717" ID="ID_936577066" MODIFIED="1456252604134" TEXT="We will use Redis as the AMQP broker">
<node CREATED="1456252604338" ID="ID_485323733" MODIFIED="1456252608222" TEXT="We can also use ActiveMQ"/>
<node CREATED="1456252608467" ID="ID_431723369" MODIFIED="1456252616669" TEXT="We can also use RabbitMQ"/>
</node>
<node CREATED="1456252630366" ID="ID_723699178" MODIFIED="1456252646694" TEXT="Final deployment will be done using docker-compose so that all services are provisioned in a single shot"/>
<node CREATED="1456252677338" ID="ID_491892727" MODIFIED="1456252679758" TEXT="Persistence">
<node CREATED="1456252649893" ID="ID_199741040" MODIFIED="1456252674638" TEXT="In Memory database like H2 will be used for this assignment"/>
<node CREATED="1456252688222" ID="ID_855617108" MODIFIED="1456252710061" TEXT="We will use Spring Data, JPA (Hibernate) as our ORM for this assignment"/>
</node>
<node CREATED="1456252731997" ID="ID_1837200614" MODIFIED="1456252752046" TEXT="Zipkin log management tool will be deployed using Docker (If needed)"/>
<node CREATED="1456263399158" ID="ID_681717221" MODIFIED="1456263419609" TEXT="Security aspect has not been looked into ">
<node CREATED="1456263420238" ID="ID_1462781564" MODIFIED="1456263429736" TEXT="No attempt to integrate with spring security has been done"/>
<node CREATED="1456263430005" ID="ID_697935719" MODIFIED="1456263439152" TEXT="No session management / secure token implementation has been done"/>
</node>
</node>
<node CREATED="1456263447688" ID="ID_550777837" MODIFIED="1456263450234" POSITION="right" TEXT="Instructions">
<node CREATED="1456263457765" ID="ID_1621603896" MODIFIED="1456263461118" TEXT="Pre-Requisites">
<node CREATED="1456263461647" ID="ID_901642607" MODIFIED="1456263463670" TEXT="JDK 1.8"/>
<node CREATED="1456263463902" ID="ID_1308480288" MODIFIED="1456263489616" TEXT="Maven 3.1.x"/>
</node>
<node CREATED="1456263501724" ID="ID_1220781" MODIFIED="1456264095690" TEXT="Step 1: Download the zip file"/>
<node CREATED="1456263525913" ID="ID_223366345" MODIFIED="1456263535835" TEXT="Step 2: Unzip in a convenient location"/>
<node CREATED="1456263536906" ID="ID_66745339" MODIFIED="1456263545636" TEXT="Step 3: Boot Config Server">
<node CREATED="1456263546090" ID="ID_458541248" MODIFIED="1456263597405" TEXT="Switch to folder ./codebase/globomart-retail-parent/globomart-config-server"/>
<node CREATED="1456263598086" ID="ID_1888976924" MODIFIED="1456263603053" TEXT="Execute: ">
<node CREATED="1456263603365" ID="ID_98380418" MODIFIED="1456263606989" TEXT="mvn spring-boot:run"/>
</node>
<node CREATED="1456263608454" ID="ID_63489125" MODIFIED="1456263619853" TEXT="Ensure the service starts successfully">
<node CREATED="1456263630500" ID="ID_1134566318" MODIFIED="1456263646484" TEXT="http://localhost:9000/application/master"/>
<node CREATED="1456263715371" ID="ID_1925531747" MODIFIED="1456263716387" TEXT="http://localhost:9000/globomart-eureka-service/master"/>
<node CREATED="1456263737505" ID="ID_67947700" MODIFIED="1456263738179" TEXT="http://localhost:9000/globomart-hystrix-dashboard/master"/>
<node CREATED="1456263760497" ID="ID_954413969" MODIFIED="1456263761315" TEXT="http://localhost:9000/globomart-product-catalog-service/master"/>
<node CREATED="1456263782250" ID="ID_296638627" MODIFIED="1456263791641" TEXT="http://localhost:9000/globomart-product-price-service/master"/>
</node>
</node>
<node CREATED="1456263810602" ID="ID_824026941" MODIFIED="1456263817954" TEXT="Step 4: Boot Eureka Server">
<node CREATED="1456263546090" ID="ID_268550025" MODIFIED="1456263846792" TEXT="Switch to folder ./codebase/globomart-retail-parent/globomart-eureka-server"/>
<node CREATED="1456263598086" ID="ID_1027665902" MODIFIED="1456263603053" TEXT="Execute: ">
<node CREATED="1456263603365" ID="ID_654883272" MODIFIED="1456263606989" TEXT="mvn spring-boot:run"/>
</node>
<node CREATED="1456263608454" ID="ID_104949338" MODIFIED="1456263619853" TEXT="Ensure the service starts successfully">
<node CREATED="1456263630500" ID="ID_598425246" MODIFIED="1456263869920" TEXT="http://localhost:9001/"/>
</node>
</node>
<node CREATED="1456263897873" ID="ID_637174228" MODIFIED="1456263904996" TEXT="Step 5: Boot Hystrix Dashboard">
<node CREATED="1456263546090" ID="ID_365523042" MODIFIED="1456263920546" TEXT="Switch to folder ./codebase/globomart-retail-parent/globomart-hystrix-dashboard"/>
<node CREATED="1456263598086" ID="ID_408914049" MODIFIED="1456263603053" TEXT="Execute: ">
<node CREATED="1456263603365" ID="ID_1884754087" MODIFIED="1456263606989" TEXT="mvn spring-boot:run"/>
</node>
<node CREATED="1456263608454" ID="ID_1625179097" MODIFIED="1456263619853" TEXT="Ensure the service starts successfully">
<node CREATED="1456263630500" ID="ID_1928445392" MODIFIED="1456263936452" TEXT="http://localhost:9002/hystrix.html"/>
</node>
</node>
<node CREATED="1456263939192" ID="ID_95923539" MODIFIED="1456263949622" TEXT="Step 6: Boot Catalog Service">
<node CREATED="1456263546090" ID="ID_733232954" MODIFIED="1456263976369" TEXT="Switch to folder ./codebase/globomart-retail-parent/globomart-product-catalog-service"/>
<node CREATED="1456263598086" ID="ID_806013806" MODIFIED="1456263603053" TEXT="Execute: ">
<node CREATED="1456263603365" ID="ID_1571072253" MODIFIED="1456263606989" TEXT="mvn spring-boot:run"/>
</node>
<node CREATED="1456263608454" ID="ID_964730205" MODIFIED="1456263619853" TEXT="Ensure the service starts successfully">
<node CREATED="1456263630500" ID="ID_1621755084" MODIFIED="1456263991754" TEXT="http://localhost:9003/products"/>
</node>
<node CREATED="1456264022588" ID="ID_1173573738" MODIFIED="1456264024428" TEXT="Testing">
<node CREATED="1456263994721" ID="ID_1233326979" MODIFIED="1456264015649" TEXT="Use any REST client to do full CRUD operation"/>
</node>
</node>
<node CREATED="1456264028682" ID="ID_896803109" MODIFIED="1456264036212" TEXT="Step 7: Boot Price Service">
<node CREATED="1456263546090" ID="ID_1528035997" MODIFIED="1456264058571" TEXT="Switch to folder ./codebase/globomart-retail-parent/globomart-product-price-service"/>
<node CREATED="1456263598086" ID="ID_83880978" MODIFIED="1456263603053" TEXT="Execute: ">
<node CREATED="1456263603365" ID="ID_982957060" MODIFIED="1456263606989" TEXT="mvn spring-boot:run"/>
</node>
<node CREATED="1456263608454" ID="ID_11425905" MODIFIED="1456263619853" TEXT="Ensure the service starts successfully">
<node CREATED="1456263630500" ID="ID_1289584880" MODIFIED="1456264070987" TEXT="http://localhost:9004/products/names"/>
<node CREATED="1456300256307" ID="ID_755847639" MODIFIED="1456300258032" TEXT="http://localhost:9004/products/find_price_by_product_id?productId=1"/>
<node CREATED="1456300258692" ID="ID_86961995" MODIFIED="1456300260120" TEXT="http://localhost:9004/products/find_price_by_product_id?productId=2"/>
<node CREATED="1456300248300" ID="ID_1260589931" MODIFIED="1456300250867" TEXT="http://localhost:9004/products/find_price_by_product_id?productId=3"/>
</node>
<node CREATED="1456264022588" ID="ID_57929581" MODIFIED="1456264024428" TEXT="Testing">
<node CREATED="1456263994721" ID="ID_274443515" MODIFIED="1456300292910" TEXT="Use any REST client to do query"/>
</node>
</node>
</node>
<node CREATED="1456285784417" ID="ID_30085516" MODIFIED="1456285785777" POSITION="right" TEXT="Facts">
<node CREATED="1456285786022" ID="ID_415045906" MODIFIED="1456285809454" TEXT="If you change eureka port number to something else then you need to specify the proper URL and port number in every service&apos;s property file."/>
</node>
</node>
</map>
