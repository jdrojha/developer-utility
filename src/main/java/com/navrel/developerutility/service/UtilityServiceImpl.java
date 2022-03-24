package com.navrel.developerutility.service;

import com.gdit.navrel.node.JsonReader;
import com.gdit.navrel.node.NodeHelper;
import com.navrel.developerutility.domain.CyberRisk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.springframework.beans.factory.annotation.Value;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.io.gryo.GryoMapper;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UtilityServiceImpl implements UtilityService {

    Logger logger = LogManager.getLogger(UtilityServiceImpl.class);


    @Value("classpath:json/root_schema_ns.json")
    Resource rootSchemaFile;

    @Value("classpath:json/root_service_ns.json")
    Resource rootServiceFile;

    @Value("classpath:json/root_thread_ns.json")
    Resource rootThreadFile;

    @Override
    public void loadData() {
        List<String> dataPath = new ArrayList<>();
        dataPath.add(rootSchemaFile.toString());
        dataPath.add(rootServiceFile.toString());
        dataPath.add(rootThreadFile.toString());
        GraphTraversalSource inMemoryDB = TinkerGraph.open().traversal();
        ClassLoader classLoader = this.getClass().getClassLoader();
        logger.info("Loading schema into %s database...");
        loadData(dataPath, inMemoryDB, classLoader);
        logger.info("datapath ->"+dataPath.toString()
        +"In Memory DB"+inMemoryDB);
        logger.info(String.format("Finished loading data into database..."));
    }

    private void loadData(List<String> dataPath, GraphTraversalSource gts, ClassLoader classLoader) {
        GraphTraversalSource gTransient = TinkerGraph.open().traversal();
        JsonReader jsonReader = new JsonReader(gTransient.getGraph());

        dataPath.forEach((file) -> {
            InputStream is = classLoader.getResourceAsStream(file);
            schema.Namespace ns = jsonReader.readFromFile(is, schema.Namespace.class).orElse(null);
            if(ns != null) {
               // if(!gts.V().has(VATTR_QNAME, ns.getQname()).has(VATTR_NODE_TYPE, ns.getNodeType()).hasNext()) {
                    NodeHelper.writeNode(ns, gts);
               // }
            }
        });
    }
}
