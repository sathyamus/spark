### Zeppelin
   - Interactive Data Analytics

#### Zeppelin Notebook
   - Choose Intrpreter as ilvy2
   ```
      %ilvy2.spark
      var trades = spark.read.json("abfss://raw@snsystems.dfs.core.windows.net/trade/distribute/20220430/simulation/trades.json")
      trades.count
   ```
#### Issues
   - 500 Internal Server Error
     - Restart All