package storm.bolts;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;
import java.io.File;

public class PrinterBolt extends BaseBasicBolt {

    private static final long serialVersionUID = 2548849706249993565L;
    File file;

    public void execute(Tuple input, BasicOutputCollector collector) {
        
        System.out.println(input.getIntegerByField("number"));
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }

}
