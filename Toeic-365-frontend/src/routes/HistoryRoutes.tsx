import React from "react"
import { Route, Switch } from "react-router-dom"
import { Path } from "../constants/path";
import App from "../app/App";
import HistoryExam from "../pages/user/History/HistoryExam";

export default function HistoryRoutes() {
    return (
        <Switch>
            <Route
                exact={true}
                path={Path.History}
                component={() => (<HistoryExam />)}
            />
        </Switch>
    )
}