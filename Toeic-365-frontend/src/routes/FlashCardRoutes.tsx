import React from "react"
import { Route, Switch } from "react-router-dom"
import { Path } from "../constants/path";
import FlashcardClient from "../pages/user/Flashcard/FlashcardClient";

export default function FlashcardRoutes() {
    return (
        <Switch>
            <Route
                exact={true}
                path={Path.Flashcard}
                component={() => (<FlashcardClient />)}
            />
        </Switch>
    )
}