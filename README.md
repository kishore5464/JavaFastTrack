
Java 8
-------------------------------------------------------------------------------------

    Exceptions

        UnChecked
            we do not handle unchecked exceptions, rather they must be avoided through
            defencive programming.

            class EmployeeServiceImpl {
                public void raieSalary(Employee emp,double percent){
                    if(emp!=null) {
                        emp.setSalary(emp.getSalary() + (emp.getSalary()*percent));
                    }
                }
            }

        Checked
            try...catch statement to handle checked exceptions.

        try-with-resources

            try(Connection con = DriverManager.getConnection(dbUrl,ui,pwd)){
                //make use of the con
            }catch(SQLException exp)){
                
            } //con.close is no more needed.

        try-with-multiCatch

            try{

            }catch(Exception1 | Exception2 | Exception3 exp ){
                //exception handle code...
            }

            try{

            }catch(IOException | SQLException exp){
                //
            }

    Collections

        for(Employee emp : empList){
            //not possible to add or remove an employee from empList
            //for situtaiton of this kind we need concurrent collections.
        }

    
    Funtional Interface, is an interface that has one and only 
    abstract method. @FunctionalInterface.

        Lambda Expression are used to implement functional interfaces.

        FunctionInterface obj = (paramList) -> (returnValue);

        FunctionInterface obj = (paramList) -> {
            //do the implementation here..

            return returnValue;
        };

        Suppliers           only return but has no param
        Consumers           does not return but accepts a param
        Predicates          always return boolean.
        Functions           accepta parmas nad return a valeu other than boolean.

        java.util.function


    Streams API

        offers a class called Stream from java.util.stream.

        Each Stream represents a one-way flow of data.

        Stream s1 = collectionObj.stream();
        Stream s2 = Arrays.stream(array);
        Stream s3 = Stream.of(e1,e2,e3,....);

            Stream
                Terminal Operations
                ------------------------------
                forEach(Consumer)           not returning anything hence stream operations can not be continued
                collect(Collector)          returns a list/set/map on which stream operations can not be continued
                reduce(BinaryOperator)      returns a single element on which stream operations can not be continued


                Intermidate Operatiosn as each of them return a stream and stream operatiosn can continue
                ----------------------------------------------------------------------------------------------
                filter(Predicate)           a new stream of filtered valeus is returned
                map(TranformerFunction)     a new stream of tranformed/mapped values
                
    IO Streams and NIO Streams

        Input output                    java.io

                InputStream, OutputStream
                                PrintStream
                    FileInputStream,FileOutputStream
                    DataInputStream,DataOutputStream
                    ObjectInputStream,ObjectOutputStream

                Reader, Writer
                    InputStreamReader
                    BufferedReader
                    FileReader,FileWriter
            
                IOException
                FileNotFoundException
                File

        Non Blocking input output       java.nio

            Path
            Paths
            Files
            Directories

    Assigbnment

        contacts.csv
            Vamsy Kiran,Aripaka,1985-06-11,9052224753,vamsy@gmail.com,visakhapatnam
            Sagar guru,,1989-07-11,9550204753,,Hydarabad

        1. read this file and populate a List<Contact> contacts.
        2. caliculate the age of each contact
        3. print the data in a tablular format
        4. print names of those contacts who have celebrate their birthday yestarday
        5. print names of those contacts are celebrating their birthday today
        6. print names of those contacts are going to celebrate their birthday tommorrow

JPA - Hibernate
---------------------------------------------------------------------------------------------------

    Hibernate is the implementation of a specification called JPA.

    DB  <------> DB Driver <------> JDBC <-----> APP

    ORM ?

    DB  <------> DB Driver <------> JDBC <-----> Hibernate <-----> JPA  <------> APP

                            OOP                     RDBMS

EntityDef                   Class                   Table
Property                    Field                   Column
Entity                      Object                  Row/Record

Relations
    Is A / Genralization    Inheretecne             Single Table/Joins/Individual Tables
    Has A / Assosiation
     Composition            An entity has           Single table for the entity
                            a field of complex 
                            type
                            
     Aggregation
       One2One              An entity is possing
                            another entity          Joins
       Many2One             An entity possess a     Joins   PK of one-side will becoem the FK on the many-side
       One2Many             collection of another 
                            entity

       Many2Many            a collection fo an entity       Join Table
                            is aggregated to a
                            collection
                            of another entity

                            class Department {      depts       deptId,dname
                                Long deptId;
                                String deptName;

                                //OneToMany
                                Set<Employees> emps;
                            }

                            class Employee {        emps    empid,name,sal,dno,city,state,deptId  
                                Long empId;
                                String name;
                                Double salary;

                                //composition
                                Address address;

                                //OneToOne
                                BankAccount salAccount;

                                //ManyToOne
                                Department dept;

                                //OneToMany (instead of ManyToMany with Projects)
                                Set<Contribution> contributions;
                            }

                            class Address {
                                String dno;
                                String city;
                                String state;
                            }

                            class BankAccount{      accounts    acNum,ifsc,empId(FK)
                                String acNum;
                                String ifsc;

                                //OneToOne
                                Employee holder;
                            }

                            class Projects {
                                Long prjId;
                                String projectTitle;

                                //OneToMany (instead of ManyToMany with Employees)
                                Set<Contribution> contributions;

                            }

                            class Contribution {
                                
                                Long contributionId;

                                //ManyToOne
                                Employee contributor;

                                //ManyToOne
                                Project project;
                                String role;

                            }

    JPA Entity Mapping Annotations 

        @Entity     @Id     @Column     @Transiant  @OneToOne   @ManyToOne  @OneToMany  @ManyToMany @JoinColumn @JoinTable
        @Table      @GeneratedValue     @Inheretence    @DiscrimatorColumn  @DiscrimatorValue
        @Embeded

    JPA Generation Strategies
        AUTO
        IDENTITY
        SEQUENCE

    JPA Fetech Strategies
        LAZY
        EAGER

    JPA Cascade Strtagies
        NONE
        MERGE
        PERSIST
        REMOVE
        ALL
        DETACH

    Entity Life Cycle

                                                            retrive an entity
                                                                    |
                                                                    |
        new entity      TRANSIANT   ------persist---------->   PERSISTANT <--------- -------remove-----> REMOVED
                                                                    |              |
                                                                    |              | merge
                                                                    | remove       |
                                                                DETACHEd---------->|

    JPA api
        EntityManagerFactory emf = Persistance.createEntityManagerFactory(persistenceUnitName);
        EntityManager em = emf.createEntityManager();
            |
            |- persist(entity)
            |- merge(entity)
            |- remove(entity)
            |- find(EntityClass,pkValue)
            |- createQuery(jpqlQuery)   ----------> Query :: getResultList() / getResult() / getResultStream()
            |- createQuery(EntityClass,jpqlQuery) ------> TypedQuery :: getResultList() / getResult() / getResultStream()

    Hibernate api
        SessionFactory
            | - Session
                    |- save(entity)
                    |- saveOrUpdate(entity)
                    |- update(entity)
                    |- delete(entity)
                    |- load(EntityClass,pkValue)
                    |- get(EntityClass,pkValue)
                    |- createQuery(hqlQuery)   ----------> Query 
                    |- createQuery(EntityClass,hqlQuery) ------> TypedQuery 
                    |- createCriteria(Criteria)


    Assignment 2

        Persist the below object map:

            Subscriber      sid,name,mobile,gender,mailId,subscriptions (many),paymentMode (one),deviceDetails (composition)

            Subscription    spId,channelName,rate,zonar(SPORTS|NEWS|MOVIE|GEBNERAL)

            PaymentMode     payModeId,upiId,defaultPaymentApp

            DeviceDetails   make,model

    Assignment 3

        Write JPQL/HQL Queries to 

            1. retrive all the Subscriber records.
            2. retrive no of subscriptions for each subscriber name
            3. retrive susbscriber name,mogile and mailId
            4. retrive all subscribers whose defaultPaymentApp is 'GPay'.
            5. retrive all subscribers whose upiId ends wiht 'okhdfcbank'.
            6. retrive number of subscribers for each channelName.

    Hibernate Cache
    ----------------------------------------------------------------------------

        First Level Cache

            is default and autoamtically manged by the session (entity-manager) itself .

            When an entity is in a 'persistence stage', it is monitored in the FL Cache.
            Any updations or modifications made to that entity or its assosiated
            entities is all observed and remmembered in the first-level cache.

            This ultimatly updated copy of the entity is shared with the RDBMS
            onl if the curretn txn is commited / session is evicted / session is closed.

        Second Level Cache (optional)

            we have many implementors in the market to provide the is
            second level cache.

            it is application level cache to facilitate cross-session
            caching. Mostly this is employed on a collection-level
            or a entity class level to manage data retrival performence.


Spring Framework
----------------------------------------------------------------------------------------------

    is a framework (dev-plaform) designed to support a variaty of JavaEE solutions.

    1. Very light weight and highly modular

        Spring Core             basic supportive module for all other spring modules
        Spring Bean             dependency injection via BeanFactory container
        Spring Context          dependency injection via ApplicationContext container
        Spring SpEL             spring expression language for external configuarations
        Spring Boot             auto-config and rapid application development
        Spring Data JPA         ORM on JPA (SQL databases)
        Spring Data NoSQL       is a vast package to acive ORM on no-sql databases
        Spring Web              support web mvc or rest api
        Spring WebFlux          reactive spring applications
        Spring Cloud            miscroservices
        Spring Test             testing platform
        Spring Security         authorization and authentication solutions
        Spring Batch            batch processing....
        .....etc.,

    2. Interoperable

    Dependency Injection

        is a implementation fo the idea IoC (Inversion of control).

        interface EmployeeDAO{
            
        }

        class EmployeeDAOJdbcImpl  implements EmployeeDAO {

        }

        class EmployeeDAOJpaImpl implements EmployeeDAO {

        }

        interface EmployeeService{

        }

        class EmployeeServiceImpl implements EmployeeService {

            private EmployeeDAO empDao;

            public EmployeeServiceImpl(EmployeeDAO dao){
                this.empDao = dao;
            }

            .....
        }

    Spring Bean and Spring Context
    
        Bean is any object whose life cycle is maanged by a container.

        Component is a class of the Bean, which means that the object os the component are managed by
        a container.

        Container is a piece of software that manages the life cycle of an object of a class. And
        such objects are called beans and such classes are called components.

        Configuaration  is to inform the container how many components do we have for him to manage
        and how are these components dependent on one another.

            1. Xml Based Config
            2. Annotation Based Config
            3. Java Based Config.

                @Component("")
                    @Servive("")
                    @Repository("")
                    @Controller("")
                    @Advice("")
                    ....etc.,

                @Scope("singleton|prototype|session|global-session")

                @Value("spEL-expression")       //field injection

                @Autowired                      //bean injection byType

                @Autowired
                @Qualifier("beanId")            //bean injection byName

                @Configuaration
                @ComponentScan("base-package")
                class MyConfig {

                    @Bean
                    public Scanner kbin(){
                        return new Scanner(System.in);
                    }
                }

        Spring Containers
            BeanFactory             offered by spring beans module
            ApplicationContext      offered by spring context module

    Spring Boot

        Auto-config
        RAD - Rapid Application Development.

        auto-config works with the help of starter packages.

        Creating a spring boot application
            1. STS
            2. Spring Boot CLI
            3. https://start.spring.io

        @SpringBootApplication  =   @Configuration + @ComponentScan + @PropertySource + @AutoConfig

        SpringApplication.run(ConfigurationClass.class, args);
            1. create an application context
            2. executes as many spring runner as we have in our project
            3. initiate the embeded server if any.
            4. application context is destroyed.

        Spring Runners
            CommandLineRunner       void run(String arg[])
            ApplicationRunner       void run(ApplicationArgs args)

    Spring Data JPA

        ORM automation module from spring framework.

        CrudRepository
            |
            |- JpaRepository
                |- findAll
                |- findById
                |- save
                |- deleteById
                |- existsById

        class Employee {
            private Long empId;
            private String firstName;
            private String lastName;
            private Double basicPay;
            private LocalDate dateOfJoining;
            private String mailId;

            //.....
        }

        interface EmployeeRepo extends JpaRepository<Employee,Long> {
            
            List<Employee> findAllByFirstName(String firstName);
            boolean existsByMailId(String mailId);
            Optional<Employee> findByMailId(String mailId);

            @Query("SELECT e FROM Employee e WHERE e.dateOfJoining BETWEEN :start AND :end")
            List<Employee> getAllJoinedBetween(LocalDate start,LocalDate end);
        }

        Assignment 4

            Develop a Spring boot console based application to 
                add / list and delete an entity "Consumer"


    Spring Rest

        rest - api standards

            HTTP methods mapping to the CRUD operations

            Method      URL-mapping         Operation           Success Status      Failure Status
            --------------------------------------------------------------------------------------------
            GET         /emps               Get All Employees   OK-200              400-BAD REQUEST
                                                                                    500-INTERNAL SERVER ERROR
            GET         /emps/101           Get By EmployeeId   OK-200              404-NOT FOUND
                                                                                    500-INTERNAL SERVER ERROR
            POST        /emps               Insert              CREATED-201         400-BAD REQUEST
                                                                                    500-INTERNAL SERVER ERROR
            PUT         /emps               Update              ACCEPTED-202        400-BAD REQUEST
                                                                                    500-INTERNAL SERVER ERROR  
            DELETE      /emps/101           Delete              NO CONTENT-204      404-NOT FOUND
                                                                                    500-INTERNAL SERVER ERROR


        using Spring Web to develop rest-api

            @RestController =   @Controller + @ResponseBody

            @CrossOrigin

            @RequestMapping
                @BetMapping
                @PostMapping
                @PutMapping
                @DeleteMapping

            @Consume
            @Produce

            @RequestBody

            @PathVariable           http://localhost:9999/emps/101 ; http://localhost:9999/emps/vamsy@gmail.com ; 

            @RequestParam           http://localhost:9999/emps?name=Vamsy ; http://localhost:9999/emps?mobile=9052224775 ;

            ResponseEntity<T>       a class that encapsualtes respBody and HttpStatus





