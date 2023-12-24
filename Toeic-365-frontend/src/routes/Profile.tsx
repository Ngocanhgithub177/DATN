import React from "react"
import { Route, Switch } from "react-router-dom"
import { Path } from "../constants/path";
import ProfileCurrent from "../pages/user/Profile/Profile";

export default function Profile() {
    return (
        <Switch>
            <Route
                exact={true}
                path={Path.Profile}
                component={() => (<ProfileCurrent />)}
            />
        </Switch>
    )
}