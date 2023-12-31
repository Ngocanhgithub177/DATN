import React from "react"
import { BrowserRouter } from "react-router-dom"
import DefaultAdminRoutes from "./DefaultAdminRoutes";
import AppRoutes from "./AppRoutes";
import LoginRoutes from "./LoginRoutes";
import RegisterRoutes from "./RegisterRoutes";
import ExamIntroRoutes from "./ExamIntroRoutes";
import FullExamRoutes from "./FullExamRoutes";
import TestOnlineRoutes from "./TestOnlineRoutes";
import Profile from "./Profile";
import HistoryRoutes from "./HistoryRoutes";
import FlashcardRoutes from "./FlashCardRoutes";

export default function Routes() {
    return (
        <BrowserRouter>
            <AppRoutes />
            <LoginRoutes />
            <Profile />
            <RegisterRoutes />
            <TestOnlineRoutes />
            <ExamIntroRoutes />
            <FullExamRoutes />
            <DefaultAdminRoutes />
            <HistoryRoutes/>
            <FlashcardRoutes/>
        </BrowserRouter>
    )
}