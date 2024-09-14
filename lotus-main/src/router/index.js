import { createRouter, createWebHistory } from 'vue-router'
import StaffLoginView from '../views/login/StaffLoginView.vue'
import CoordinatorLoginView from '../views/login/CoordinatorLoginView.vue'
import StudentLoginView from '../views/login/StudentLoginView.vue'
import LoginNavigationView from '../views/login/LoginNavigationView.vue'
import AdminLoginView from '../views/login/AdminLoginView.vue'

import StudentDashboardView from '../views/dashboard/student/StudentDashboardView.vue'
import StudentHomeView from '../views/dashboard/student/home/StudentHomeView.vue'
import StudentDocumentsView from '../views/dashboard/student/documents/StudentDocumentsView.vue'
import StudentMessagesView from '../views/dashboard/student/messages/StudentMessagesView.vue'
import StudentNewMessagesView from '../views/dashboard/student/messages/StudentNewMessagesView.vue'
import StudentIncomingMessagesView from '../views/dashboard/student/messages/StudentIncomingMessagesView.vue'
import StudentOutgoingMessagesView from '../views/dashboard/student/messages/StudentOutgoingMessagesView.vue'
import StudentMessageDetailsView from '../views/dashboard/student/messages/StudentMessageDetailsView.vue'

import StudentOpportunitiesView from '../views/dashboard/student/opportunities/StudentOpportunitiesView.vue'
import StudentOpportunityDetailsView from '../views/dashboard/student/opportunities/StudentOpportunityDetailsView.vue'

import CoordinatorDashboardView from '../views/dashboard/coordinator/CoordinatorDashboardView.vue'
import CoordinatorHomeView from '../views/dashboard/coordinator/home/CoordinatorHomeView.vue'
import CoordinatorMessagesView from '../views/dashboard/coordinator/messages/CoordinatorMessagesView.vue'
import CoordinatorNewMessagesView from '../views/dashboard/coordinator/messages/CoordinatorNewMessagesView.vue'
import CoordinatorIncomingMessagesView from '../views/dashboard/coordinator/messages/CoordinatorIncomingMessagesView.vue'
import CoordinatorOutgoingMessagesView from '../views/dashboard/coordinator/messages/CoordinatorOutgoingMessagesView.vue'
import CoordinatorFormProcessingView from '../views/dashboard/coordinator/form-processing/CoordinatorFormProcessingView.vue'
import CoordinatorDocumentProcessingView from '../views/dashboard/coordinator/document-processing/CoordinatorDocumentProcessingView.vue'
import CoordinatorMessageDetailsView from '../views/dashboard/coordinator/messages/CoordinatorMessageDetailsView.vue'

import AdminDashboardView from '../views/dashboard/admin/AdminDashboardView.vue'
import AdminAssignCoordView from '../views/dashboard/admin/assign/AdminAssignCoordView.vue'
import AdminAssignStaffView from '../views/dashboard/admin/assign/AdminAssignStaffView.vue'
import AdminHomeView from '../views/dashboard/admin/home/AdminHomeView.vue'

import CCDashboardView from '../views/dashboard/cc/CCDashboardView.vue'
import CCHomeView from '../views/dashboard/cc/home/CCHomeView.vue'
import CCMessagesView from '../views/dashboard/cc/messages/CCMessagesView.vue'
import CCNewMessagesView from '../views/dashboard/cc/messages/CCNewMessagesView.vue'
import CCIncomingMessagesView from '../views/dashboard/cc/messages/CCIncomingMessagesView.vue'
import CCOutgoingMessagesView from '../views/dashboard/cc/messages/CCOutgoingMessagesView.vue'
import CCMessageDetailsView from '../views/dashboard/cc/messages/CCMessageDetailsView.vue'
import CCFormsAndSGKView from '../views/dashboard/cc/forms/CCFormsAndSGKView.vue'
import CCNewOpportunityView from '../views/dashboard/cc/opportunities/CCNewOpportunityView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'LoginNavigation',
      component: LoginNavigationView
    },

    {
      path: '/staff-login',
      name: 'StaffLogin',
      component: StaffLoginView
    },
    {
      path: '/coordinator-login',
      name: 'CoordinatorLogin',
      component: CoordinatorLoginView
    },

    {
      path: '/student-login',
      name: 'StudentLogin',
      component: StudentLoginView
    },
    {
      path: '/admin-login',
      name: 'AdminLogin',
      component: AdminLoginView
    },
    {
      path: '/student-dashboard',
      name: 'StudentDashboard',
      component: StudentDashboardView,
      children: [
        {
          path: '',
          name: 'StudentHome',
          component: StudentHomeView
        },
        {
          path: 'documents',
          name: 'StudentDocuments',
          component: StudentDocumentsView
        },
        {
          path: 'messages',
          name: 'StudentMessages',
          component: StudentMessagesView,
          children: [
            {
              path: '',
              name: 'StudentNewMessages',
              component: StudentNewMessagesView
            },
            {
              path: 'incoming',
              name: 'StudentIncomingMessages',
              component: StudentIncomingMessagesView
            },
            {
              path: 'outgoing',
              name: 'StudentOutgoingMessages',
              component: StudentOutgoingMessagesView
            },
            {
              path: 'details/:id',
              name: 'StudentMessageDetails',
              component: StudentMessageDetailsView
            }
          ]
        },
        {
          path: 'opportunities',
          name: 'StudentOpportunities',
          component: StudentOpportunitiesView
        },
        {
          path: 'opportunity-details/:id',
          name: 'StudentOpportunityDetails',
          component: StudentOpportunityDetailsView
        }
      ]
    },
    {
      path: '/coordinator-dashboard',
      name: 'CoordinatorDashboard',
      component: CoordinatorDashboardView,
      children: [
        {
          path: '',
          name: 'CoordinatorHome',
          component: CoordinatorHomeView
        },
        {
          path: 'messages',
          name: 'CoordinatorMessages',
          component: CoordinatorMessagesView,
          children: [
            {
              path: '',
              name: 'CoordinatorNewMessages',
              component: CoordinatorNewMessagesView
            },
            {
              path: 'incoming',
              name: 'CoordinatorIncomingMessages',
              component: CoordinatorIncomingMessagesView
            },
            {
              path: 'outgoing',
              name: 'CoordinatorOutgoingMessages',
              component: CoordinatorOutgoingMessagesView
            },
            {
              path: 'details/:id',
              name: 'CoordinatorMessageDetails',
              component: CoordinatorMessageDetailsView
            }
          ]
        },
        {
          path: 'form-processing',
          name: 'CoordinatorFormProcessing',
          component: CoordinatorFormProcessingView
        },
        {
          path: 'document-processing',
          name: 'CoordinatorDocumentProcessing',
          component: CoordinatorDocumentProcessingView
        }
      ]
    },
    {
      path: '/admin-dashboard',
      name: 'AdminDashboard',
      component: AdminDashboardView,
      children: [
        {
          path: '',
          name: 'AdminHome',
          component: AdminHomeView
        },
        {
          path: 'assign-coordinator',
          name: 'AdminAssignCoord',
          component: AdminAssignCoordView
        },
        {
          path: 'assign-staff',
          name: 'AdminAssignStaff',
          component: AdminAssignStaffView
        }
      ]
    },
    {
      path: '/cc-dashboard',
      name: 'CCDashboard',
      component: CCDashboardView,
      children: [
        {
          path: '',
          name: 'CCHome',
          component: CCHomeView
        },
        {
          path: 'messages',
          name: 'CCMessages',
          component: CCMessagesView,
          children: [
            {
              path: '',
              name: 'CCNewMessages',
              component: CCNewMessagesView
            },
            {
              path: 'incoming',
              name: 'CCIncomingMessages',
              component: CCIncomingMessagesView
            },
            {
              path: 'outgoing',
              name: 'CCOutgoingMessages',
              component: CCOutgoingMessagesView
            },
            {
              path: 'details/:id',
              name: 'CCMessageDetails',
              component: CCMessageDetailsView
            }
          ]
        },
        {
          path: 'forms-and-sgk',
          name: 'CCFormsAndSGK',
          component: CCFormsAndSGKView
        },
        {
          path: 'new-opportunity',
          name: 'CCNewOpportunity',
          component: CCNewOpportunityView
        }
      ]
    },
    {
      path: '/:catchAll(.*)*',
      redirect: { name: 'LoginNavigation' }
    }
  ]
})

export default router
