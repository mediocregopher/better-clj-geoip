# better-clj-geoip

A thin wrapper for MaxMind's geoip library

## Usage

Add `[org.clojars.mediocregopher/better-clj-geoip "0.1"]` to dependencies.

```clojure
user=> (use 'better-clj-geoip.core)
nil
user=> (def ls (geoip-init "/tmp/GeoIPCity.dat"))
#'user/ls
user=> ls
#<LookupService com.maxmind.geoip.LookupService@6298e03e>
user=> (lookup-location ls "8.8.8.8")
{:countryName "United States", :area-code 0, :longitude -97.0, :postalCode nil, :latitude 38.0, :city nil, :metro-code 0, :region nil, :countryCode "US", :dma-code 0, :ip "8.8.8.8"}
user=> (lookup-location ls "172.16.1.1")
nil
user=> (geoip-close ls)
nil
```

## License

Copyright © 2013 FIXME

Distributed under the Eclipse Public License, the same as Clojure.
