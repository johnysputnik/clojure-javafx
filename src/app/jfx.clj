;; Some java fx macros
;;
(ns app.jfx
  (:import (javafx.beans.value ChangeListener)
           (javafx.event ActionEvent EventHandler)
           (javafx.scene Scene)
           (javafx.fxml FXMLLoader)))

(defmacro fx-load-fxml [path]
  `(let [loc# (clojure.java.io/resource ~path)]
     (FXMLLoader/load loc#)))

(defmacro fx-add-text-listener [text-property action]
  `(.addListener ~text-property
                 (reify ChangeListener
                   (changed [this obsval oldval newval]
                     ~action))))

(defmacro fx-window [stage view title]
  `(let [root# (.loadFxml ~view)]
     (.setScene ~stage (Scene. root#))
     (.setTitle ~stage ~title)
     (.show ~stage)))

(defmacro fx-action [node action]
  `(.setOnAction ~node
                 (proxy [EventHandler] []
                   (handle [^ActionEvent event#]
                     ~action))))
