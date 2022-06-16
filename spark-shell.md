### spark-shell
   - hdfs dfs -get abfss://app@sathyaprivatestorage.dfs.core.windows.net/sathya/sathya.keytab
   - spark-shell --principal ${USER}@AZURE.ONMICROSOFT.COM --keytab ${USER}.keytab --num-executors 5 --conf "spark.driver.memory=8G" --executor-memory 3G
   - vi flat-20220616.scala
   - Load the file
     :load /home/AZURE/user/sathya/flat-20220616.scala
   - Results can be seen in console, for any show commands
