package storm.helloworld;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;

/**
 * Topology class that sets up the Storm topology for this sample.
 * Please note that Twitter credentials have to be provided as VM args, otherwise you'll get an Unauthorized error.
 * @link http://twitter4j.org/en/configuration.html#systempropertyconfiguration
 */
public class Topology {

	static final String TOPOLOGY_NAME = "storm-twitter-hello-world";

	public static void main(String[] args) {
		Config config = new Config();
		config.setMessageTimeoutSecs(120);

		TopologyBuilder b = new TopologyBuilder();
		b.setSpout("TwitterSampleSpout", new TwitterSampleSpout());
        b.setBolt("PrintOutBolt", new PrintOutBolt()).shuffleGrouping("TwitterSampleSpout");

		final LocalCluster cluster = new LocalCluster();
		cluster.submitTopology(TOPOLOGY_NAME, config, b.createTopology());

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				cluster.killTopology(TOPOLOGY_NAME);
				cluster.shutdown();
			}
		});

	}

}
