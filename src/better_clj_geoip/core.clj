(ns better-clj-geoip.core
    (import com.maxmind.geoip.LookupService))

(defn geoip-init
    [datloc]
    (LookupService. datloc))

(defn geoip-close
    [ls]
    (.close ls))

(defn lookup-location
    [ls ip]
    (when-let [loc (.getLocation ls ip)]
        { :ip          ip
          :countryCode ( .countryCode loc )
          :countryName ( .countryName loc )
          :region      ( .region      loc )
          :city        ( .city        loc )
          :postalCode  ( .postalCode  loc )
          :latitude    ( .latitude    loc )
          :longitude   ( .longitude   loc )
          :dma-code    ( .dma_code    loc )
          :area-code   ( .area_code   loc )
          :metro-code  ( .metro_code  loc ) }))
