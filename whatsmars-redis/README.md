# [Redis](https://github.com/antirez/redis)
Redis is an in-memory database that persists on disk. The data model is key-value,
but many different kind of values are supported: Strings, Lists, Sets, Sorted Sets,
Hashes, HyperLogLogs, Bitmaps. https://redis.io http://redis.net.cn

### Jedis连接方式
![jedis](jedis.png)

### 基于M-S模式下读写分离
通常情况下，Slave只是作为数据备份，不提供read操作，这种考虑是为了避免slave提供stale数据而导致一些问题。
不过在很多场景下，即使slave数据有一定的延迟，我们仍然可以兼容或者正常处理，此时我们可以将slave提供read
服务，并在M-S集群中将read操作分流，此时我们的Redis集群将可以支撑更高的QPS。本实例中，仅仅提供了“读写分
离”的样板，尚未对所有的redis方法进行重写和封装，请开发者后续继续补充即可。此外，slave节点如果异常，我们
应该支持failover，这一部分特性后续再扩展。

### Spring Data Redis
SDR对Redis对标准模式和Cluster模式进行了充分封装，但并未对sharding模式进行良好封装，需要开发者自己实现，
这也是SDR和Jedis相比，唯一缺少的特性。另外，Redis官网给出了一个Redis的Java客户端列表，SDR支持Jedis,
Lettuce，Spring Boot 2.x默认使用Lettuce。(早期Redis还没有Cluster特性，所以较早出现的Redis的Java
客户端大都自己实现了分片和集群功能，相比分片，SDR显然更提倡Cluster)

### MORE
- [如何根据key前缀统计内存占用](https://segmentfault.com/q/1010000010575235)