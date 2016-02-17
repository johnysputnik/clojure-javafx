(ns app.view
  (:gen-class
   :name app.view.Main
   :prefix view-
   :methods [[loadFxml [] javafx.scene.Parent]])
  (:import (javafx.scene Parent))
  (:use [app.jfx]))

(defn view-loadFxml [this]
  "Load the FXML and create a view for display in a parent"
  (let [root (fx-load-fxml "window.fxml")x
        ;; get references to the ids in the FXML
        clear-button (.lookup root "#clearButton")
        echo-text (.lookup root "#echoTextField")
        edit-text (.lookup root "#textField")]

    ;; add an action to the clear button

    (fx-action clear-button
               (do
                 (.setText echo-text "")
                 (.setText edit-text "")))

    ;; add a listener to the text property on the edit control

    (fx-add-text-listener (.textProperty edit-text)
                          (.setText echo-text
                                    (.getText edit-text)))

    ;; return the root

    root))
