package storm.bolts;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;

public class PrinterBolt extends BaseBasicBolt{

	private static final long serialVersionUID = 2548849706249993565L;
	File file;

	public void execute(Tuple input, BasicOutputCollector collector) {
		
		try {
			file = new File("/home/dev/output.txt");
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(input.toString());
			bw.close();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		
	}
	

}
