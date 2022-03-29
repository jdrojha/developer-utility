package com.navrel.developerutility.service;
import com.navrel.developerutility.domain.CyberRisk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/*import org.apache.thinkerpop.*;
import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.apache.tinkerpop.gremlin.driver.Cluster.Builder;
import org.apache.tinkerpop.gremlin.driver.remote.DriverRemoteConnection;
import org.apache.tinkerpop.gremlin.driver.ser.GryoMessageSerializerV3d0;
import org.apache.tinkerpop.gremlin.process.traversal.AnonymousTraversalSource;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.io.gryo.GryoMapper;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;
import org.janusgraph.graphdb.tinkerpop.JanusGraphIoRegistry;*/
import org.apache.tinkerpop.gremlin.process.traversal.Bindings;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.util.empty.EmptyGraph;
import org.janusgraph.core.JanusGraphFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.janusgraph.core.schema.JanusGraphIndex;
import org.janusgraph.core.schema.JanusGraphManagement;
import java.util.Map;
import org.apache.tinkerpop.gremlin.structure.Graph;
import static org.apache.tinkerpop.gremlin.process.traversal.AnonymousTraversalSource.traversal;
@Service
public class UtilityServiceImpl implements UtilityService {

    Logger logger = LogManager.getLogger(UtilityServiceImpl.class);
    // used for bindings
    private static final String NAME = "name";
    private static final String AGE = "age";
    private static final String TIME = "time";
    private static final String REASON = "reason";
    private static final String PLACE = "place";
    private static final String LABEL = "label";
    private static final String OUT_V = "outV";
    private static final String IN_V = "inV";

    @Override
    public List<Object> findDataFromMemory() {
        return null;
    }

    @Override
    public void loadDataFromMemory() {
        try {
           // Graph graph = graph = JanusGraphFactory.build().set('storage.backend', 'inmemory').open();//EmptyGraph.instance();
           // GraphTraversalSource g = traversal().withRemote("conf/remote-graph.properties");
           // createElements(g);
           //g.addV("Test").property("Value","Rajesh");
           // Object herculesAge = g.V().has(NAME, "saturn").next();
            logger.info("Started .");
            JanusGraphApp.runGraph();
            logger.info("Completed .");



        } catch (Exception ex) {
            logger.info("Exception while initializing Grapah "+ex);
            ex.printStackTrace();
        }

    }
    public void createElements(GraphTraversalSource g) {
        logger.info("creating elements");

        // Use bindings to allow the Gremlin Server to cache traversals that
        // will be reused with different parameters. This minimizes the
        // number of scripts that need to be compiled and cached on the server.
        // https://tinkerpop.apache.org/docs/3.2.6/reference/#parameterized-scripts
        final Bindings b = Bindings.instance();

        // see GraphOfTheGodsFactory.java

        Vertex saturn = g.addV(b.of(LABEL, "titan")).property(NAME, b.of(NAME, "saturn"))
                .property(AGE, b.of(AGE, 10000)).next();

    }
  /*  private static void loadData(List<String> dataPath,
                                 GraphTraversalSource gts, ClassLoader classLoader) {

        GraphTraversalSource gTransient = TinkerGraph.open().traversal();
        //JsonReader jsonReader = new JsonReader(gTransient.getGraph());

        dataPath.forEach((file) -> {
            InputStream is = classLoader.getResourceAsStream(file);
            // schema.Namespace ns = jsonReader.readFromFile(is, schema.Namespace.class).orElse(null);

        });
    }*/

}
