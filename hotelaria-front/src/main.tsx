import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import { SetorPage } from './pages/Setores/SetorPage'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <SetorPage />
  </StrictMode>,
)
