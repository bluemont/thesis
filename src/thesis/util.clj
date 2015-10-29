(ns thesis.util)

(defn safe-get
  "Returns value corresponding to key in map, if present. Otherwise
  raises an exception."
  [m k]
  (if (contains? m k)
    (get m k)
    (throw (ex-info "Key not found in map." {:map m :key k}))))
