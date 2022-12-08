## Query API Overview


<br>
<table style="font-size: 14px">
    <thead>
        <tr>
            <th style="width: 80px">Query Mode</th>
            <th>Native Hibernate API (<code>Session</code>)</th>
            <th>JPA API (<code>EntityManager</code>)</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th rowspan="4">SQL (Native Queries)</th>
            <td><code>createNativeQuery(sql) : 
                NativeQuery &lt;Object[]&gt;</code></td>
            <td><code>createNativeQuery(sql) : 
                Query</code></td>
        </tr>
        <tr>
            <td><code>createNativeQuery(sql, Tuple.class): NativeQuery &lt;Tuple&gt;</code></td>
            <td><code>createNativeQuery(sql, Tuple.class): Query</code></td>
        </tr>
        <tr>
            <td>
                <code>createNativeQuery(sql).addEntity(entity.class) : 
                NativeQuery &lt;Entity&gt;</code></td>
            <td>
                -
            </td>
        </tr>
        <tr>
            <td><code>createNativeQuery(sql, entity.class) : NativeQuery &lt;Entity&gt;</code></td>
            <td><code>createNativeQuery(sql, entity.class) : Query</code></td>
        </tr>
        <tr>
            <th rowspan="3">Named Native Queries (<code>@NamedNativeQuery</code>)</th>
            <td>
                <code>getNamedNativeQuery(query-name) : NativeQuery &lt;Object[] | Entity&gt;</code>
            </td>
            <td>
                -
            </td>
        </tr>
        <tr>
            <td>
                <code>createdNamedQuery(query-name) : Query &lt;Object[] | Entity&gt;</code>
            </td>
            <td>
                <code>createdNamedQuery(query-name) : Query</code>
            </td>
        </tr>
        <tr>
            <td>
                <code>createdNamedQuery(query-name, entity.class) : Query &lt;Entity&gt;</code>
            </td>
            <td>
                <code>createdNamedQuery(query-name, entity.class) : TypedQuery &lt;Entity&gt;</code>
            </td>
        </tr>
        <tr>
            <th rowspan="2">JPQL | HQL</th>
            <td>
                <code>createQuery(hql) : Query &lt;Object[] | Entity&gt;</code>
            </td>
            <td>
                <code>createQuery(jpql) : Query</code>
            </td>
        </tr>
        <tr>
            <td>
                <code>createQuery(hql, entity.class) : Query &lt;Entity&gt;</code>
            </td>
            <td>
                <code>createQuery(jpql, entity.class) : TypedQuery &lt;Entity&gt;</code>
            </td>
        </tr>
        <tr>
            <th rowspan="3">
                Named Queries (<code>@NamedQuery</code>)
            </th>
            <td>
                <code>getNamedQuery(query-name) : Query &lt;Object[] | Entity&gt;</code>
            </td>
            <td>
                -
            </td>
        </tr>
        <tr>
            <td>
                <code>createNamedQuery(query-name) : Query &lt;Object[] | Entity&gt;</code>
            </td>
            <td>
                <code>createNamedQuery(query-name) : Query</code>
            </td>
        </tr>
        <tr>
            <td>
                <code>createNamedQuery(query-name, entity.class) : Query &lt;Entity&gt;</code>
            </td>
            <td>
                <code>createNamedQuery(query-name, entity.class) : TypedQuery &lt;Entity&gt;</code>
            </td>
        </tr>
    </tbody>
</table>