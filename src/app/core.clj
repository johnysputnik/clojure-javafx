;; The javafx application with a main function and an
;; overridden start method
;;
(ns app.core
  (:gen-class :extends javafx.application.Application)
  (:import (javafx.application Application)
           (javafx.scene Scene))
  (:use [app.jfx]
        [app.view]))

(defn -main [& args]
  (Application/launch app.core args))

(defn -start [this stage]
  (fx-window stage (app.view.Main.) "JavaFXML with Clojure"))
