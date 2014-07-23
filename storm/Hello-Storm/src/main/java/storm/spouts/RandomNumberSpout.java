package storm.spouts;

import java.util.Map;
import java.util.Random;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;

public class RandomNumberSpout extends BaseRichSpout {
    
    SpoutOutputCollector _collector;
    Random _rand;
    
    private static final long serialVersionUID = 5495037345245833790L;
    
    public void open(@SuppressWarnings("rawtypes") Map conf, TopologyContext context,
            SpoutOutputCollector collector) {
        _collector = collector;
        _rand = new Random();
    }
    
    public void nextTuple() {
        Utils.sleep(1000);
        int value = _rand.nextInt(10000);
        _collector.emit(new Values(value), value);        
    }
    
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("number"));
    }
    
}
