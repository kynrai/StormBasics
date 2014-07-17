package storm.topology;

import storm.bolts.PrinterBolt;
import storm.spouts.RandomNumberSpout;
import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.InvalidTopologyException;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.utils.Utils;

@SuppressWarnings("unused")
public class PrintNumberStream {

	public static void main(String[] args) throws AlreadyAliveException, InvalidTopologyException {
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("numbersGenerator", new RandomNumberSpout());
		builder.setBolt("print", new PrinterBolt()).shuffleGrouping("numbersGenerator");
		
		Config conf = new Config();
		conf.setDebug(true);
		conf.setNumWorkers(2);
		conf.setMaxTaskParallelism(4);
		
		// Use this to run a local cluster for testing the topology
		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("PrintTopology", conf, builder.createTopology());
		
		Utils.sleep(60000);
		
		cluster.shutdown();
		
		// Use this to deploy into your storm cluster
		// e.g. path/to/storm jar this.jar storm.topology.PrintNumberStream
		// StormSubmitter.submitTopology("PrintTopology", conf, builder.createTopology());
		
	}

}
