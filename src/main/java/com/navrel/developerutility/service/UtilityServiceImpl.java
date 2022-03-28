package com.navrel.developerutility.service;
import com.navrel.developerutility.domain.CyberRisk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.thinkerpop.*;
import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.apache.tinkerpop.gremlin.driver.Cluster.Builder;
import org.apache.tinkerpop.gremlin.driver.remote.DriverRemoteConnection;
import org.apache.tinkerpop.gremlin.driver.ser.GryoMessageSerializerV3d0;
import org.apache.tinkerpop.gremlin.process.traversal.AnonymousTraversalSource;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.io.gryo.GryoMapper;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;
import org.janusgraph.graphdb.tinkerpop.JanusGraphIoRegistry;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UtilityServiceImpl implements UtilityService {

    Logger logger = LogManager.getLogger(UtilityServiceImpl.class);


    @Override
    public List<Object> findDataFromMemory() {
        return null;
    }

    @Override
    public void loadDataFromMemory() {
        //Graph graph = EmptyGraph.instance();
        //  GraphTraversalSource g = graph.traversal().withRemote("conf/remote-graph.properties");

        GraphTraversalSource inMemoryDB = TinkerGraph.open().traversal();
        if (!dataPath.isEmpty()) {

            logger.info("Loading schema into %s database...");
            loadData(dataPath, inMemoryDB, classLoader);
            logger.info("Finished loading data into database...");
        }

    }
    private static void loadData(List<String> dataPath,
                                 GraphTraversalSource gts, ClassLoader classLoader) {

        GraphTraversalSource gTransient = TinkerGraph.open().traversal();
        //JsonReader jsonReader = new JsonReader(gTransient.getGraph());

        dataPath.forEach((file) -> {
            InputStream is = classLoader.getResourceAsStream(file);
            // schema.Namespace ns = jsonReader.readFromFile(is, schema.Namespace.class).orElse(null);

        });
    }

}
