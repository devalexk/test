package edu.olezha.jsandbox.collections;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class GetOnSet {

    public static void main(String[] args) {
        Map<KV, KV> kvKvSet = new HashMap<KV, KV>() {{
            for (Long i = 0L; i < 20; i++) {
                KV kv = new KV(i, i.toString() + "k", i, i.toString() + "v");
                put(kv, kv);
            }
        }};
        log.info("{}", kvKvSet.get(new KV(1L, "1k", null, null)));

        Map<K, V> kvSet = new HashMap<K, V>() {{
            for (Long i = 0L; i < 20; i++) {
                K k = new K(i, i.toString() + "k");
                put(k, new V(k, i, i.toString() + "v"));
            }
        }};
        log.info("{}", kvSet.get(new K(1L, "1k")));
    }
}

@Data
class KV {
    private final Long a;
    private final String b;
    private Long c;
    private String d;

    KV(Long a, String b, Long c, String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        KV kv = (KV) object;

        return (getA().equals(kv.getA()))
                && (getB().equals(kv.getB()));
    }

    @Override
    public int hashCode() {
        return 1;
    }
}

@Data
class K {
    private final Long a;
    private final String b;

    K(Long a, String b) {
        this.a = a;
        this.b = b;
    }
}

@Data
class V {
    private Long c;
    private String d;
    private K k;

    V(K k, Long c, String d) {
        this.k = k;
        this.c = c;
        this.d = d;
    }
}
