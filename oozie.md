### Oozie

oozie job -run -config  job.properties 
oozie job -oozie http://localhost:11000/oozie -config examples/apps/map-reduce/job.properties -run

$ oozie job -oozie http://localhost:11000/oozie -D nameNode=hdfs://localhost:9000 -D jobTracker=localhost:8032 -config $OOZIE_HOME/examples/apps/map-reduce/job.properties -run

$ export nameNode=hdfs://localhost:9000

$ export jobTracker=localhost:8032

$ echo $nameNode

hdfs://localhost:9000

$ echo ${nameNode}

hdfs://localhost:9000

$ oozie job -oozie http://localhost:11000/oozie -config $OOZIE_HOME/examples/apps/map-reduce/job.properties -run -D nameNode=${nameNode} -D jobTracker=${jobTracker}

job: 0000004-150401113103094-oozie-user-W

Additional Oozie Commands:
1) Submit job:
$ oozie job -oozie http://localhost:11000/oozie -config examples/apps/map-reduce/job.properties -submit
job: 0000012-130712212133144-oozie-oozi-W

2) Run job:
$ oozie job -oozie http://localhost:11000/oozie -start 0000014-130712212133144-oozie-oozi-W

3) Check the status:
$ oozie job -oozie http://localhost:11000/oozie -info 0000014-130712212133144-oozie-oozi-W

4) Suspend workflow:
$ oozie job -oozie http://localhost:11000/oozie -suspend 0000014-130712212133144-oozie-oozi-W

5) Resume workflow:
$ oozie job -oozie http://localhost:11000/oozie -resume 0000014-130712212133144-oozie-oozi-W

6) Re-run workflow:
$ oozie job -oozie http://localhost:11000/oozie-config examples/apps/map-reduce/job.properties -rerun 0000014-130712212133144-oozie-oozi-W

7) Should you need to kill the job:
$ oozie job -oozie http://localhost:11000/oozie -kill 0000014-130712212133144-oozie-oozi-W

8) View server logs:
$ oozie job -oozie http://localhost:11000/oozie -logs 0000014-130712212133144-oozie-oozi-W


Logs are available at:
/var/log/oozie on the Oozie server.

http://hadooptutorial.info/category/bi-big-data/